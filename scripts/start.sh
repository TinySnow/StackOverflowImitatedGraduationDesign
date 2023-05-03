#! /usr/bin/env bash

set -Eexuo pipefail

service mysql start

java -jar StackOverflowImitatedGraduationDesign/etc/backend.jar &

serve -p 5173 frontend/dist &

StackOverflowImitatedGraduationDesign/logstash-7.6.2/bin/logstash &