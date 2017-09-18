#!/bin/sh


cd ../../
BASE_PATH=$(pwd)
RESULTS_PATH="$HOME/gatling/results/"

mkdir -p $RESULTS_PATH

docker run -it --rm \
-e SHOOT_BASE_URL=http://127.0.0.1:8080 \
-v "$BASE_PATH/others/gatling/conf":/opt/gatling/conf \
-v "$BASE_PATH/part1/test/user-files":/opt/gatling/user-files \
-v "$RESULTS_PATH":/opt/gatling/results \
denvazh/gatling