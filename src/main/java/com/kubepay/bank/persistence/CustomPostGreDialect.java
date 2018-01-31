package com.kubepay.bank.persistence;

import org.hibernate.dialect.PostgreSQL9Dialect;

public class CustomPostGreDialect extends PostgreSQL9Dialect {
    @Override
    public boolean dropConstraints() {
        return false;
    }
}
