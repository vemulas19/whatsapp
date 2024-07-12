#!/bin/bash

# Sync whitelisted commits
copybara copy.bara.sky filter_and_sync

# Track non-whitelisted commits
copybara copy.bara.sky sync_to_target