import boto3

ec2 = boto3.resource('ec2')
ins = boto3.client('ec2')

for instance in ec2.instances.all():
    for vol in instance.volumes.all():
        for tag in instance.tags:
            if tag['Key'] == 'Name':
                ins.create_tags(
                    Resources=[vol.id],
                    Tags=[{
                        'Key':'' + tag.get('Key'),
                        'Value':'' + tag.get('Value')
                    },]
            )
