/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__fromDB_format_01.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-01.tmpl.java
*/
/*
* @description
* CWE: 134 Uncontrolled Format String
* BadSource: fromDB Read a string from a database connection
* GoodSource: A hardcoded string
* Sinks: format
*    GoodSink: dynamic formatted stdout with string defined
*    BadSink : dynamic formatted stdout without validation
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE134_Uncontrolled_Format_String;

import testcasesupport.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE134_Uncontrolled_Format_String__fromDB_format_01 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* setup the connection */
            conn = IO.getDBConnection();

            /* prepare the query */
            statement = conn.prepareStatement("select name from users where id=?");

            /* get user input for the userid */
            IO.writeLine("Enter a userid to login as (number): ");
            instrread = new InputStreamReader(System.in);
            buffread = new BufferedReader(instrread);
            int num = Integer.parseInt(buffread.readLine());
            statement.setInt(1, num);
            rs = statement.executeQuery();

            data = rs.getString(1);
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing instrread");
                }
            }

            /* clean up database objects */
            try {
                if( rs != null )
                {
                    rs.close();
                }
            }
            catch( SQLException se )
            {
                log_bad.warning("Error closing rs");
            }
            finally {
                try {
                    if( statement != null )
                    {
                        statement.close();
                    }
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error closing statement");
                }
                finally {
                    try {
                        if( conn != null )
                        {
                            conn.close();
                        }
                    }
                    catch( SQLException se)
                    {
                        log_bad.warning("Error closing conn");
                    }
                }
            }
        }

        /* POTENTIAL FLAW: uncontrolled string formatting */
        System.out.format(data);

    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        /* POTENTIAL FLAW: uncontrolled string formatting */
        System.out.format(data);

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* setup the connection */
            conn = IO.getDBConnection();

            /* prepare the query */
            statement = conn.prepareStatement("select name from users where id=?");

            /* get user input for the userid */
            IO.writeLine("Enter a userid to login as (number): ");
            instrread = new InputStreamReader(System.in);
            buffread = new BufferedReader(instrread);
            int num = Integer.parseInt(buffread.readLine());
            statement.setInt(1, num);
            rs = statement.executeQuery();

            data = rs.getString(1);
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing instrread");
                }
            }

            /* clean up database objects */
            try {
                if( rs != null )
                {
                    rs.close();
                }
            }
            catch( SQLException se )
            {
                log_bad.warning("Error closing rs");
            }
            finally {
                try {
                    if( statement != null )
                    {
                        statement.close();
                    }
                }
                catch( SQLException se )
                {
                    log_bad.warning("Error closing statement");
                }
                finally {
                    try {
                        if( conn != null )
                        {
                            conn.close();
                        }
                    }
                    catch( SQLException se)
                    {
                        log_bad.warning("Error closing conn");
                    }
                }
            }
        }

        /* FIX: explicitly defined string formatting */
        System.out.format("%s\n", data);

    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}

