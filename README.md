# WeatherApp ☁️🌡️

Jednoduchá desktopová aplikace v Javě, která zobrazuje aktuální počasí pro zvolená města pomocí **WeatherAPI.com**.

## 📌 Funkce
- Zobrazení aktuální teploty a podmínek pro vybrané město.
- Seznam míst (zemí/měst) s možností přidávat nová.
- Aktualizace počasí pomocí tlačítka **Refresh**.
- Grafické uživatelské rozhraní v **Java Swing**.

## 🛠️ Použité technologie
- **Java 11+**
- **Swing** pro GUI
- **OkHttp** pro HTTP požadavky
- **org.json** pro zpracování JSON odpovědí

## 📥 Instalace a spuštění
1. **Naklonuj projekt:**
   ```sh
   git clone https://github.com/tvoje-repozitory/weather-app.git
   cd weather-app
   ```

2. **Pokud používáš Maven**, přidej knihovny do `pom.xml`:
   ```xml
   <dependencies>
       <dependency>
           <groupId>com.squareup.okhttp3</groupId>
           <artifactId>okhttp</artifactId>
           <version>4.9.3</version>
       </dependency>
       <dependency>
           <groupId>org.json</groupId>
           <artifactId>json</artifactId>
           <version>20210307</version>
       </dependency>
   </dependencies>
   ```

3. **Pokud Maven nepoužíváš**, ručně stáhni knihovny:
   - [OkHttp JAR](https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp)
   - [org.json JAR](https://mvnrepository.com/artifact/org.json/json)
   - Přidej je do projektu ve VS Code (Java Build Path → Add External JARs).

4. **Získej API klíč z [WeatherAPI.com](https://www.weatherapi.com/)** a nahraď ho do `WeatherAPI.java`:
   ```java
   private static final String API_KEY = "TVUJ_API_KLIC";
   ```

5. **Spusť hlavní třídu:**
   ```sh
   java -cp target/weather-app.jar com.GUI.AppGUI
   ```

## 📌 Použití API
Aplikace stahuje počasí pomocí tohoto endpointu:
```sh
http://api.weatherapi.com/v1/current.json?key=TVUJ_API_KLIC&q=London&aqi=no
```

## 🔗 Odkazy
- [WeatherAPI.com](https://www.weatherapi.com/)
- [OkHttp dokumentace](https://square.github.io/okhttp/)
- [org.json dokumentace](https://stleary.github.io/JSON-java/)

