#AVALIAÇÃO SUBSTITUTIVA
Avaliação Substitutiva

# Variáveis de Sistema para o WildFly

1. Com o WildFly rodando, acessar http://localhost:8080/console
2. Clique na aba "Configuration"
3. Clique em "System Properties" e então em "View"
4. Clique em "Add" e adicione as seguintes variáveis de sistema, com seus respectivos valores:

        <property name="br.com.theodoro.push-host" value="https://localhost:8443/avaliacao"/>
        <property name="br.com.theodoro.private-key" value="6c851e94-1490-4058-a47b-a9695e741f1e"/>
        <property name="br.com.theodoro.system-code" value="3044a91a-8acf-4f08-8db0-7a71304ebe6e"/>
        <property name="br.gov.sp.tce.dti.ssda.ambiente.desenv" value="true"/>
        
         <datasource jta="true" jndi-name="java:jboss/datasources/AvaliacaoDS" pool-name="avaliacao" enabled="true" use-ccm="true">
                    <connection-url>jdbc:postgresql://10.26.4.103:5432/avaliacao</connection-url>
                    <driver-class>org.postgresql.Driver</driver-class>
                    <driver>postgresql-9.4.1207.jar</driver>
                    <security>
                        <user-name>postgres</user-name>
                        <password>postgres</password>
                    </security>
                    <validation>
                        <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLValidConnectionChecker"/>
                        <background-validation>true</background-validation>
                        <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLExceptionSorter"/>
                    </validation>
                </datasource>
               