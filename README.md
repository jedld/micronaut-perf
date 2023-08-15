# Pyroscope Performance Testing

### Requirements

The following are needed in your system to run tests:

- Docker
- docker compose

### Run using docker-compose

Navigate to project directory and run docker compose, make sure to change the
pyroscope url and user credentials in the environment inside the docker-compose.yml.

```
cd micronaut-perf
sudo docker-compose up
```

This will boot up a micronaut service in ports 8086 and 8087.

### Run the tests

Test performance with Pyroscope Enabled

```
docker run --network=host --rm -i grafana/k6 run --vus 100 --iterations=10000  -e url=http://localhost:8086/test/city <test_scripts/testurl.js
```

Test performance with Pyroscope Disabled

```
docker run --network=host --rm -i grafana/k6 run --vus 100 --iterations=10000  -e url=http://localhost:8087/test/city <test_scripts/testurl.js
```

