#!/bin/env bash

################################
# TinySnow created on 2023.2.8 #
################################
set -Eeuxo pipefail

git add .

git commit -m "$1"

git push