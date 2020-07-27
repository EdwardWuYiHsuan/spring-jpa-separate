package spring.jpa.separate.filter;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.orm.jpa.vendor.Database;

public class ExcludeUnnecessDbFilter implements TypeFilter {

	private Database database;

	public ExcludeUnnecessDbFilter() {
		try {
			Resource resource = new ClassPathResource("/application.properties");
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			String jpaDatabase = props.getProperty("spring.jpa.database");
			if (null != jpaDatabase && !jpaDatabase.isEmpty()) {
				this.database = Database.valueOf(jpaDatabase.toUpperCase());
			} else {
				throw new IllegalArgumentException(
						"Could not resolve placeholder 'spring.jpa.database' in class ExcludeUnnecessDbFilter");
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Could not resolve placeholder 'spring.jpa.database' in class ExcludeUnnecessDbFilter");
		}
	}

	@Override
	public boolean match(MetadataReader metadataReader,
			MetadataReaderFactory metadataReaderFactory) throws IOException
	{
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		switch (database) {
			case ORACLE:
				return classMetadata.getClassName().startsWith("spring.jpa.separate.model.sql_server");
			case SQL_SERVER:
				return classMetadata.getClassName().startsWith("spring.jpa.separate.model.oracle");
			default: return false;
		}
	}

}
