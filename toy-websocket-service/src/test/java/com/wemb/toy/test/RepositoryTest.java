package com.wemb.toy.test;

import com.wemb.toy.config.TestProfile;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles(TestProfile.TEST)
@DataJpaTest (showSql = true )
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Ignore
public class RepositoryTest {

}
