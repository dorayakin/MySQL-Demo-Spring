FROM mysql:8.0

COPY ./conf.d/my.cnf /etc/mysql/conf.d/my.cnf

RUN chmod 644 /etc/mysql/conf.d/my.cnf

RUN mkdir -p /var/log/mysql \
    && chown -hR mysql:mysql /var/log/mysql