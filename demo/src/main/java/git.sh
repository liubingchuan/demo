#!/bin/bash
cd /root/lbc-test
git checkout -b test
git add b.txt
git commit -m "test branch to be reviewed"
git push origin test