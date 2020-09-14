package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import ro.johann.thoughts.model.Thought;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
public class ThoughtOutput {

    private final String id;
    private final String value;
    private final LocalDateTime createdAt;
    private final LanguageOutput language;

    public ThoughtOutput(Thought thought) {
        this.id = thought.getId();
        this.value = thought.getValue();
        this.createdAt = thought.getCreatedAt();
        this.language = new LanguageOutput(thought.getLanguage());
    }

}

