# Spring Stream Concurrency

POC to test usage of `concurrency` consumer property on Spring Cloud Stream.

## TL;DR

If concurrency is configured with `1` all partitions consumed by the application are queued, so if you've a topic with 5 partitions, all messages published on then will be executed in order of consumption.

## Disclaimer

Messages in the same partition will not be executed in parallel.

## Dependencies

- Docker

## Usage

- Run `docker compose up -d` to execute all dependencies
- Create a topic called `events.json` on `localhost:8580`
- Send messages to `events.json` topic and saw the behavior on app logs
