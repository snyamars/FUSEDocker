# Use latest jboss/base-jdk:7 image as the base
FROM jboss/base-jdk:7

MAINTAINER Hiram Chirino <hchirino@redhat.com>

# Set the FUSE_VERSION env variable
ENV FUSE_VERSION 6.2.0.redhat-060

# If the container is launched with re-mapped ports, these ENV vars should
# be set to the remapped values.
ENV FUSE_PUBLIC_OPENWIRE_PORT 61616
ENV FUSE_PUBLIC_MQTT_PORT 1883
ENV FUSE_PUBLIC_AMQP_PORT 5672
ENV FUSE_PUBLIC_STOMP_PORT 61613
ENV FUSE_PUBLIC_OPENWIRE_SSL_PORT 61617
ENV FUSE_PUBLIC_MQTT_SSL_PORT 8883
ENV FUSE_PUBLIC_AMQP_SSL_PORT 5671
ENV FUSE_PUBLIC_STOMP_SSL_PORT 61614

# Install fuse in the image.
COPY install.sh /opt/jboss/install.sh
RUN /opt/jboss/install.sh

EXPOSE 8181 8101 1099 44444 61616 1883 5672 61613 61617 8883 5671 61614
COPY users.properties /opt/jboss/jboss-fuse/etc/
COPY org.apache.karaf.features.cfg /opt/jboss/jboss-fuse/etc/
COPY org.ops4j.pax.url.mvn.cfg /opt/jboss/jboss-fuse/etc/
COPY mysql-connector-java-5.1.35.jar /opt/jboss/jboss-fuse/deploy/
COPY org.apache.servicemix.bundles.commons-dbcp-1.4_3.jar /opt/jboss/jboss-fuse/deploy/
COPY FuseStack-1.0.0-SNAPSHOT.jar /opt/jboss/jboss-fuse/deploy/

#
# The following directories can hold config/data, so lets suggest the user
# mount them as volumes.
VOLUME /opt/jboss/jboss-fuse/bin
VOLUME /opt/jboss/jboss-fuse/data
VOLUME /opt/jboss/jboss-fuse/deploy

# lets default to the jboss-fuse dir so folks can more easily navigate to around the server install
WORKDIR /opt/jboss/jboss-fuse
CMD /opt/jboss/jboss-fuse/bin/fuse server
