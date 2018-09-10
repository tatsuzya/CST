import boto3
import sys

ec2 = boto3.resource('ec2')
client = boto3.client('ec2')

for instance in ec2.instances.all():
        print(instance.id)
        print(instance.instance_type)        

instance =raw_input('Enter the instance id: \n')
vol = raw_input('Enter the volume: \n')

client.stop_instances(InstanceIds=[instance])

waiter=client.get_waiter('instance_stopped')
waiter.wait(InstanceIds=[instance])

client.modify_instance_attribute(InstanceId=instance, Attribute='instanceType', Value=''+vol)
client.start_instances(InstanceIds=[instance])
