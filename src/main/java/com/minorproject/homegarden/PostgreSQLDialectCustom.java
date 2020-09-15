package com.minorproject.homegarden;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQL82Dialect;
import org.hibernate.type.descriptor.sql.LongVarcharTypeDescriptor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

public class PostgreSQLDialectCustom extends PostgreSQL82Dialect {

	public PostgreSQLDialectCustom() {
		System.out.println("Init PostgreSQLDialectCustom");
		registerColumnType(Types.BLOB, "bytea");

	}

	@Override
	public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor) {
		if (Types.CLOB == sqlTypeDescriptor.getSqlType()) {
			return LongVarcharTypeDescriptor.INSTANCE;
		}
		return super.remapSqlTypeDescriptor(sqlTypeDescriptor);
	}
}
