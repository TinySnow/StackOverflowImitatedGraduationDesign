#! /usr/bin/env bash

set -Eexuo pipefail

service mysql start

java -jar /home/snow/backend-0.0.1-SNAPSHOT.jar &

serve -l 5173 /home/snow/frontend &