package com.pedromonteiro.qaapi.domain.question;

import java.util.Objects;

import com.pedromonteiro.qaapi.domain.Identifier;
import com.pedromonteiro.qaapi.domain.utils.IdUtils;

public class QuestionID extends Identifier {

    private final String value;


    public QuestionID(final String anId) {
        Objects.requireNonNull(anId);
        this.value = anId;
    }


    @Override
    public String getValue() {
        return this.value;
    }

    public static QuestionID unique() {
        return QuestionID.from(IdUtils.uuid());
    }

    public static QuestionID from(final String anId) {
        return new QuestionID(anId);
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        QuestionID other = (QuestionID) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    
    
}
