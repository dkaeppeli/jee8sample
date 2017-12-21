FROM airhacks/wildfly
COPY ./target/jee8sample.war ${DEPLOYMENT_DIR}
