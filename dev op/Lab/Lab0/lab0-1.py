import boto3
import sys

ec2 = boto3.resource('ec2')
ins = boto3.client('ec2')

action = sys.argv[1].lower()     #start / stop
t = sys.argv[2]                  #tags

for instance in ec2.instances.all():
    if instance.tags is None:
        continue
    for tag in instance.tags:
        if tag['Key'] == '' +  t:
            if action == 'start':
                ins.start_instances(InstanceIds=[instance.instance_id])
            else:
                ins.stop_instances(InstanceIds=[instance.instance_id])
