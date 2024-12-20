package ru.phestrix.letter;

import java.util.List;

public class LetterCreator {
    private List<String> missingUrls;
    private List<String> changedUrls;
    private List<String> newUrls;

    public LetterCreator(List<String> missingUrls, List<String> changedUrls, List<String> newUrls) {
        this.missingUrls = missingUrls;
        this.changedUrls = changedUrls;
        this.newUrls = newUrls;
    }

    public void printLetter() {
        StringBuilder letter = new StringBuilder();
        letter.append("Здравствуйте, дорогая и.о. секретаря\n");
        letter.append("За последние сутки во вверенных Вам сайтах произошли следующие изменения:\n");

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
}
