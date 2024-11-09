# Manga Notification Service

**Just a simple web scraper to send discord notifications when new manga chapters appear**

![discord_banana_car.png](pictures/discord_view.png)

## Set up

1. Make sure to set up `application-secrets.properties` with following secrets

```properties
discord.channelId=replace-secret
discord.token=replace-secret
```

2. Run `docker build -t manga-notification-svc -f Dockerfile .`
3. Start application `docker compose up -d`

## Schema changes

1. Add new database migration in `src/main/resources/db/changelog`
2. Start application
3. Run `./gradlew :generateJooq`

Database classes should now appear in `src/main/generated-db-entities`