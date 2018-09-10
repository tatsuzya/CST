#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <time.h>
#include <pwd.h>
#include <grp.h>

int main(int argc, char **argv){
    if(argc != 2){
        perror("wrong input\n");
        return 1;
    }

    struct stat file;   // file stat
    if(stat(argv[1],&file) == -1){
        perror("stat\n");
        return 1;
    }

    struct passwd *pw;
    if((pw = getpwuid(file.st_uid)) == NULL){
        perror("getpwuid\n");
        return 1;
    }

    struct group *grp;
    if((grp = getgrgid(file.st_gid)) == NULL){
        perror("getgrgid\n");
        return 1;
    }
    printf("name:                 %s\n" , argv[1]);
    printf("device #              %lu\n", file.st_dev);
    printf("i-number:             %lu\n", file.st_ino);
    printf("# of links:           %lu\n", file.st_nlink);
    printf("user ID:              %ul(%s)\n", file.st_uid, pw -> pw_name);
    printf("group ID:             %ul(%s)\n", file.st_gid, grp -> gr_name);
    printf("mode:                 %ul(", file.st_mode);
    printf((S_ISDIR(file.st_mode)) ? "d" :"-");
    printf((file.st_mode & S_IRUSR) ? "r" :"-");
    printf((file.st_mode & S_IWUSR) ? "w" : "-");
    printf((file.st_mode & S_IXUSR) ? "x" : "-");
    printf((file.st_mode & S_IRGRP) ? "r" : "-");
    printf((file.st_mode & S_IWGRP) ? "w" : "-");
    printf((file.st_mode & S_IXGRP) ? "x" : "-");
    printf((file.st_mode & S_IROTH) ? "r" : "-");
    printf((file.st_mode & S_IWOTH) ? "w" : "-");
    printf((file.st_mode & S_IXOTH) ? "x" : "-");
    printf(")\n");
    printf("size:                 %lu\n", file.st_size);
    printf("access time:          %s", ctime(&file.st_atime));
    printf("modification time:    %s", ctime(&file.st_mtime));
    printf("status change time:   %s", ctime(&file.st_ctime));

    return 0;
}
