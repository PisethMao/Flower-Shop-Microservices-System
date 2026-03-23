FROM quay.io/debezium/connect:3.4.0.Final
USER root
ENV PLUGIN_DIR=/etc/kafka-connect/config
RUN mkdir -p $PLUGIN_DIR
RUN curl -L -o $PLUGIN_DIR/kafka-connect-avro-converter.jar \
    https://packages.confluent.io/maven/io/confluent/kafka-connect-avro-converter/7.3.0/kafka-connect-avro-converter-7.3.0.jar && \
    curl -L -o $PLUGIN_DIR/kafka-connect-avro-data.jar \
    https://packages.confluent.io/maven/io/confluent/kafka-connect-avro-data/7.3.0/kafka-connect-avro-data-7.3.0.jar && \
    curl -L -o $PLUGIN_DIR/kafka-avro-serializer.jar \
    https://packages.confluent.io/maven/io/confluent/kafka-avro-serializer/7.3.0/kafka-avro-serializer-7.3.0.jar && \
    curl -L -o $PLUGIN_DIR/kafka-schema-serializer.jar \
    https://packages.confluent.io/maven/io/confluent/kafka-schema-serializer/7.3.0/kafka-schema-serializer-7.3.0.jar && \
    curl -L -o $PLUGIN_DIR/kafka-schema-converter.jar \
    https://packages.confluent.io/maven/io/confluent/kafka-schema-converter/7.3.0/kafka-schema-converter-7.3.0.jar && \
    curl -L -o $PLUGIN_DIR/kafka-schema-registry-client.jar \
    https://packages.confluent.io/maven/io/confluent/kafka-schema-registry-client/7.3.0/kafka-schema-registry-client-7.3.0.jar && \
    curl -L -o $PLUGIN_DIR/common-config.jar \
    https://packages.confluent.io/maven/io/confluent/common-config/7.3.0/common-config-7.3.0.jar && \
    curl -L -o $PLUGIN_DIR/common-utils.jar \
    https://packages.confluent.io/maven/io/confluent/common-utils/7.3.0/common-utils-7.3.0.jar && \
    curl -L -o $PLUGIN_DIR/avro.jar \
    https://repo1.maven.org/maven2/org/apache/avro/avro/1.11.0/avro-1.11.0.jar && \
    curl -L -o $PLUGIN_DIR/commons-compress.jar \
    https://repo1.maven.org/maven2/org/apache/commons/commons-compress/1.21/commons-compress-1.21.jar && \
    curl -L -o $PLUGIN_DIR/failureaccess.jar \
    https://repo1.maven.org/maven2/com/google/guava/failureaccess/1.0.1/failureaccess-1.0.1.jar && \
    curl -L -o $PLUGIN_DIR/guava.jar \
    https://repo1.maven.org/maven2/com/google/guava/guava/30.1.1-jre/guava-30.1.1-jre.jar && \
    curl -L -o $PLUGIN_DIR/minimal-json.jar \
    https://repo1.maven.org/maven2/com/eclipsesource/minimal-json/minimal-json/0.9.5/minimal-json-0.9.5.jar && \
    curl -L -o $PLUGIN_DIR/re2j.jar \
    https://repo1.maven.org/maven2/com/google/re2j/re2j/1.6/re2j-1.6.jar && \
    curl -L -o $PLUGIN_DIR/slf4j-api.jar \
    https://repo1.maven.org/maven2/org/slf4j/slf4j-api/1.7.36/slf4j-api-1.7.36.jar && \
    curl -L -o $PLUGIN_DIR/snakeyaml.jar \
    https://repo1.maven.org/maven2/org/yaml/snakeyaml/1.33/snakeyaml-1.33.jar && \
    curl -L -o $PLUGIN_DIR/swagger-annotations.jar \
    https://repo1.maven.org/maven2/io/swagger/core/v3/swagger-annotations/2.1.10/swagger-annotations-2.1.10.jar && \
    curl -L -o $PLUGIN_DIR/jackson-databind.jar \
    https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.13.2.2/jackson-databind-2.13.2.2.jar && \
    curl -L -o $PLUGIN_DIR/jackson-core.jar \
    https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.13.2/jackson-core-2.13.2.jar && \
    curl -L -o $PLUGIN_DIR/jackson-annotations.jar \
    https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.13.2/jackson-annotations-2.13.2.jar && \
    curl -L -o $PLUGIN_DIR/jackson-dataformat-csv.jar \
    https://repo1.maven.org/maven2/com/fasterxml/jackson/dataformat/jackson-dataformat-csv/2.13.2/jackson-dataformat-csv-2.13.2.jar && \
    curl -L -o $PLUGIN_DIR/logredactor.jar \
    https://packages.confluent.io/maven/io/confluent/logredactor/1.0.10/logredactor-1.0.10.jar && \
    curl -L -o $PLUGIN_DIR/logredactor-metrics.jar \
    https://packages.confluent.io/maven/io/confluent/logredactor-metrics/1.0.10/logredactor-metrics-1.0.10.jar
RUN mkdir -p /opt/oracle && \
    curl -fL -o instantclient-basic.zip \
    https://download.oracle.com/otn_software/linux/instantclient/2326100/instantclient-basic-linux.x64-23.26.1.0.0.zip && \
    curl -fL -o instantclient-jdbc.zip \
    https://download.oracle.com/otn_software/linux/instantclient/2326100/instantclient-jdbc-linux.x64-23.26.1.0.0.zip && \
    curl -fL -o instantclient-sqlplus.zip \
    https://download.oracle.com/otn_software/linux/instantclient/2326100/instantclient-sqlplus-linux.x64-23.26.1.0.0.zip
RUN unzip -o instantclient-basic.zip -d /opt/oracle && \
    unzip -o instantclient-jdbc.zip -d /opt/oracle && \
    unzip -o instantclient-sqlplus.zip -d /opt/oracle && \
    rm -f instantclient-basic.zip instantclient-jdbc.zip instantclient-sqlplus.zip
RUN mkdir -p /kafka/libs && \
    (cp /opt/oracle/instantclient_23_26/*.jar /kafka/libs/ 2>/dev/null || true) && \
    ls -la /kafka/libs/
ENV LD_LIBRARY_PATH=/opt/oracle/instantclient_23_26:$LD_LIBRARY_PATH
ENV ORACLE_HOME=/opt/oracle/instantclient_23_26
ENV PATH=/opt/oracle/instantclient_23_26:$PATH
RUN chown -R kafka:kafka /kafka/libs /opt/oracle
USER kafka