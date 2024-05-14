FROM postgres:16.1

ENV POSTGRES_DB smartfitdb
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD 123

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 5432

CMD ["postgres"]
