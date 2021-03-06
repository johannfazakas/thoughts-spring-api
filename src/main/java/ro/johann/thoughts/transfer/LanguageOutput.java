package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import ro.johann.thoughts.model.Language;

@Getter
@ToString
@EqualsAndHashCode
public class LanguageOutput {

    private final String id;
    private final String name;

    public LanguageOutput(Language language) {
        this.id = language.getId();
        this.name = language.getName();
    }
}
