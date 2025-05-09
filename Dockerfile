FROM ubuntu:latest
LABEL authors="song"

ENTRYPOINT ["top", "-b"]