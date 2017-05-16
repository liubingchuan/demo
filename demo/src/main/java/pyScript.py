#!/usr/bin/python
#coding=utf-8
import os
import time
import sys
f=open('/root/lbc-test/b.txt','a')
f.write(os.popen('netstat -nltp | grep 22').read())
f.close()
