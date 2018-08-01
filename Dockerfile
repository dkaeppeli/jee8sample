#FROM airhacks/wildfly
#COPY ./target/jee8sample.war ${DEPLOYMENT_DIR}

FROM payara/server-full:latest

# Setup configuration
USER payara
COPY lib/postgresql-42.2.2.jar /opt/payara5/glassfish/domains/domain1/lib
COPY domain.xml /opt/payara5/glassfish/domains/domain1/config
COPY ./target/jee8sample.war /opt/payara5/deployments