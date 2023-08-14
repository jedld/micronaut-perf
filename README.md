## Micronaut 3.10.0 Documentation

- [User Guide](https://docs.micronaut.io/3.10.0/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.10.0/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.10.0/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

# How to run tests

We use k6 build with kafka support for http and kafka tests.
### Build Custom K6
#### Prerequisites:
- go (>=1.7)
- k6 (0.34.1)
- git

#### Install xk6 module:
xk6 is a command line tool for building custom k6 with extensions such as for testing Kafka and MySQL.  
`$ go install go.k6.io/xk6/cmd/xk6@latest`

#### Make sure `$HOME/go/bin` is in the PATH variable.
`export PATH="$PATH:$HOME/go/bin"`

#### Build custom k6 binary for Kafka and MySQL:
`$ xk6 build v0.34.1 --output $HOME/go/bin/k6-custom --with github.com/mostafa/xk6-kafka@v0.6.0 --with github.com/imiric/xk6-sql`

