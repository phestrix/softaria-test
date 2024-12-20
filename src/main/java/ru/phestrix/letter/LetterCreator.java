package ru.phestrix.letter;

import java.util.List;

public class LetterCreator {
    private final List<String> missingUrls;
    private final List<String> changedUrls;
    private final List<String> newUrls;
    private StringBuilder letter;
    public LetterCreator(List<String> missingUrls, List<String> changedUrls, List<String> newUrls) {
        this.missingUrls = missingUrls;
        this.changedUrls = changedUrls;
        this.newUrls = newUrls;
    }

    public void printLetter() {
        letter = new StringBuilder();
        letter.append("Здравствуйте, дорогая и.о. секретаря\n\n");
        letter.append("За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n\n");

        appendSection(letter, "Исчезли следующие страницы:", missingUrls);
        appendSection(letter, "Появились следующие новые страницы:", newUrls);
        appendSection(letter, "Изменились следующие страницы:", changedUrls);

        letter.append("\nС уважением,\nавтоматизированная система\nмониторинга");

        System.out.println(letter);
    }

    private void appendSection(StringBuilder letter, String header, List<String> urls) {
        letter.append(header).append("\n");
        urls.forEach(url -> letter.append(url).append("\n"));
    }

    public String getLetter() {
        return letter.toString();
    }
}
