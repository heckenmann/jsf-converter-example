package de.heckenmann.jsfconverter;

/**
 * Symbolisiert ein Entity, das direkt aus der Datenbank gelesen wird und im Dropdown angezeigt wird.
 * @author Ben
 *
 */
public class ClassToConvert {

    public int id;

    private String text;

    public ClassToConvert(final int id, final String text) {
        this.text = text;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
