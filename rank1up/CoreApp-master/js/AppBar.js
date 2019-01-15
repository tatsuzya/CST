let AppBar = function() {
}

AppBar.prototype = {
    //Initializes appbar
    init: function(appbarContainer) {
        this.appbarContainer = appbarContainer;
        this.generateAppBar();
        this.searchInit();
        this.timer = null;
    },
    /**
     * Dynamically generates the appbar depending on if user is logged in.
     * 
     * @param appbarContainer Element.   the container to put appbar in
     */
    generateAppBar: function(appbarContainer) {
        let loggedInUser = this.checkSession();
        let appbar = '<div class="nav-wrapper nav-inner">';
        appbar += '<a href="/"><img class="responsive-img mini-logo left" src="./img/mini.png"><img class="responsive-img nav-logo left" src="./img/rankup.png"></a>';
        appbar += '<ul class="left search-ul">';
        appbar += '<div class="input-field searchbar">';
        appbar += '<input id="search" type="search" class="autocomplete" autocomplete="off">';
        appbar += '<label class="label-icon" for="search"><i class="material-icons">search</i></label>';
        appbar += '<i class="material-icons">close</i>';
        appbar += '</div>';
        appbar += '<div class="search-results z-depth-2" hidden>';
        appbar += '<div class="row">';
        appbar += '<div class="col s4"><select id="filterApp" class="filterusers">';
        appbar += '<option value="" selected>None</option>';
        appbar += '<option value="hangman">Hang Man</option>';
        appbar += '<option value="js">JavaScript</option>';
        appbar += '<option value="android">Android</option>';
        appbar += '</select></div>';
        appbar += '<div class="col s4"><select id="filter" class="filterusers" disabled>';
        appbar += '<option value="top" selected>Top</option>';
        appbar += '<option value="bottom">Bottom</option>';
        appbar += '</select></div>';
        appbar += '<div class="col s4"><input id="percent" class="filteusers" type="number" min="1" max="100" value="100" disabled>';
        appbar += '<label for="percent" class="purple-text">Percent</label></div>';
        appbar += '</div><div class="divider"></div>';
        appbar += '<ul class="search-list">Search for a user</ul>';
        appbar += '</div></ul>';
        if (loggedInUser) {
            appbar += '<ul id="userMenu" class="dropdown-content">';
            appbar += '<li><a href="./UserProfile.html">Profile</a></li>';
            appbar += '<li><a href="./Settings.html">Settings</a></li>';
            appbar += '<li class="divider"></li>';
            appbar += '<li><a id="logoutBtn" href="#!" class="red-text">Logout</a></li>';
            appbar += '</ul>'; 
        }
        appbar += '<ul class="right">';
        appbar += '<li><a href="/"><i class="material-icons">home</i></a></li>';
        if (loggedInUser) {
            appbar += '<li><a href="./Message.html"><i class="material-icons">message</i></a></li>';
            appbar += `<li><a class="dropdown-trigger" href="#!" data-target="userMenu">${loggedInUser}<i class="material-icons right">arrow_drop_down</i></a></li>`;
        } else {
            appbar += '<li><a href="./Login.html">Sign In</a></li>';
        }
        appbar += '</ul>';
        appbar += '</div>';
        this.appbarContainer.html(appbar);
        $('select').formSelect();
        if (loggedInUser) {
            $('.dropdown-trigger').dropdown({
                coverTrigger: false
            });
            $('#logoutBtn').click(this.logout.bind(this));
        }
    },
    /**
     * Hides preloader.
     */
    hidePreloader: function() {
        $('.preloader').css('opacity', 0);
        $('.page-content').css('opacity', 1);
        $('body').css('background-color', '#fafafa');
        setTimeout(() => { 
            $('.preloader').hide(); 
        }, 500);
    },
    /**
     * Initializes search, adding listeners to input, selectors.
     */
    searchInit: function() {
        $('#filterApp').change((event)=>{
            if ($('#filterApp').val() == '') {
                $('#filter').attr('disabled', true);
                $('#percent').attr('disabled', true);
            } else {
                $('#filter').attr('disabled', false);
                $('#percent').attr('disabled', false);
            }
            $('select').formSelect();
        });
        $('#search').focus(() => {
            $('.search-results').show();
        });
        $('#search').on('input', () => {
            this.startSearch();
        });
        $('.filterusers').change(this.startSearch.bind(this));
        $('#percent').on('input', () => {
            this.startSearch();
        });
        $('body').click((event) => {
            if (event.target != $('#search')[0] && !$('.search-results').has(event.target).length) {
                $('.search-results').hide(); 
                $('.search-list').html('Search for a user');
                $('#search').val('');
                $('#filter').attr('disabled', true);
                $('#percent').attr('disabled', true);
                $('#filterApp').val('');
                $('select').formSelect();
            }
        });
    },
    /**
     * Starts a search using the values from input and filter.
     */
    startSearch: function() {
        let filterApp = $('#filterApp').val();
        let searchInput = $('#search').val();
        let filterType;
        if (this.timer) {
            clearTimeout(this.timer);
        }
        this.timer = setTimeout(()=> {
            if (searchInput || filterApp != '') {
                if ($('#percent').val() <= 0 || $('#percent').val() > 100) {
                    $('.search-list').html('Invalid percent');
                } else {
                    if (filterApp != '') {
                        filterType = $('#filter').val();
                        percent = $('#percent').val();
                    }
                    this.searchUsers(searchInput, filterApp, filterType, percent);
                }
            } else {
                $('.search-list').html('Search for a user');
            }
        }, 300);
    },
    /**
     * Sends post request to search API.
     * @param search String.       data in search input.
     * @param filterApp String.    app to filter by.
     * @param filterType String.   whether to filer top or bottom percent.
     * @param percent Number.      percent to filter by.
     */
    searchUsers: function(search, filterApp, filterType, percent) {
        let json = {
            'search': search,
            'filterApp': filterApp,
            'filterType': filterType,
            'percent': percent
        };
        $.ajax({
            url:'https://c5pnhcawsc.execute-api.us-west-1.amazonaws.com/Development/search',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(json),
            success: this.loadSearchResults,
            error: this.searchError
        });
    },
    /**
     * Parse results, build html and add to search results container.
     * @param results Object.   result from API call.
     */
    loadSearchResults: function(results) {
        let resultsHtml = '';
        if (results.length > 0) {
            results.forEach((user) => {
                let fullname = user.fName + ' ' + user.lName;
                resultsHtml += '<li class="result-li"><a class="black-text" href="./UserProfile.html?userSub=' + user.userSub + '">' + fullname + ' (' + user.emailAddress + ')</a></li>'
            });
        } else {
            resultsHtml = 'No results';
        }
        $('.search-list').html(resultsHtml);
    },
    /**
     * Logs to console if error occurs during API call.
     * @param error Object. Error from API response.
     */
    searchError: function(error) {
        console.log("Search ajax error");
    },
    /**
     * Checks local storage for user object.
     * @return user's given name String. 
     */
    checkSession: function() {
        let curUser = localStorage.getItem('rankUpUser');
        let utc = new Date().getTime();
        if (curUser) {
            curUser = JSON.parse(curUser)
            if (utc < new Date(curUser.Expiration).getTime()) {
                return curUser['given_name'];
            } else {
                localStorage.setItem('rankUpUser', '');
                return null;
            }
        }
    },
    /**
     * Logs a user out by clearing local storage and redirecting to login page.
     */
    logout: function() {
        localStorage.removeItem('rankUpUser');
        window.location.replace('./Login.html');
    }
}