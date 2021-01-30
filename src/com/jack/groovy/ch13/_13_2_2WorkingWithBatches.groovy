package com.jack.groovy.ch13

/**
 * @author liangchen* @date 2020/12/1
 */
// 批量


sql = DbUtil.create();
sql.execute '''
CREATE TABLE Record (

  runId       INTEGER ,

  time        INTEGER,    -- in seconds

  venue       VARCHAR(64),

  whenRun     DATE,

  fkAthlete   INTEGER,

  CONSTRAINT fk FOREIGN KEY (fkAthlete)

    REFERENCES Athlete (athleteId) ON DELETE CASCADE

);
'''
sql.withBatch {
    stmt ->
        stmt.addBatch '''
    INSERT INTO Athlete(firstname,lastname, dateOfBirth)
       VALUES('Paula', 'Radclife','1973-12-17')
'''
}


def qry = '''
    INSERT INTO Athlete(firstname, lastname, dateOfBirth) VALUES(?,?,?)
'''
sql.withBatch (3, qry){ps->
    ps.addBatch('Paula',     'Radcliffe',   '1973-12-17')

    ps.addBatch('Catherine', 'Ndereba',     '1972-07-21')

    ps.addBatch('Naoko',     'Takahashi',   '1972-05-06')

    ps.addBatch('Tegla',     'Loroupe',     '1973-05-09')

    ps.addBatch('Ingrid',    'Kristiansen', '1956-03-21')

}

