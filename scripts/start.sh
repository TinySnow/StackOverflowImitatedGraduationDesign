#! /usr/bin/env bash

set -Eexuo pipefail

service mysql start

java -jar /home/snow/StackOverflowImitatedGraduationDesign/etc/backend.jar &

serve -p 5173 /home/snow/frontend/dist &

/home/snow/StackOverflowImitatedGraduationDesign/logstash-7.6.2/bin/logstash &