#!/bin/bash
#
#installation git-nodejs-vim
#############################################################

sudo apt-get -y update
sudo apt-get install -y git-core
sudo apt-get install -y vim-nox
curl -sL https://deb.nodesource.com/setup_8.x | sudo -E bash - 
sudo apt-get install -y nodejs
sudo apt-get install -y build-essential
