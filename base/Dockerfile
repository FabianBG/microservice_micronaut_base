FROM oracle/graalvm-ce:19.2.1 as graalvm
COPY . /home/app/base
WORKDIR /home/app/base
RUN gu install native-image
RUN native-image --no-server -cp build/libs/base-*-all.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/base .
ENTRYPOINT ["./base"]
