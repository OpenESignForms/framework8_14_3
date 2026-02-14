package com.vaadin.server;

import java.util.Enumeration;
import java.util.Properties;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;

/**
 * Mock servlet configuration for tests.
 *
 * @author Vaadin Ltd
 */
public class MockServletConfig implements ServletConfig {

    private ServletContext context = new MockServletContext();
    private final Properties initParameters;

    public MockServletConfig() {
        this(new Properties());
    }

    public MockServletConfig(Properties initParameters) {
        this.initParameters = initParameters;
    }

    /*
     * (non-Javadoc)
     *
     * @see jakarta.servlet.ServletConfig#getServletName()
     */
    @Override
    public String getServletName() {
        return "Mock Servlet";
    }

    /*
     * (non-Javadoc)
     *
     * @see jakarta.servlet.ServletConfig#getServletContext()
     */
    @Override
    public ServletContext getServletContext() {
        return context;
    }

    /*
     * (non-Javadoc)
     *
     * @see jakarta.servlet.ServletConfig#getInitParameter(java.lang.String)
     */
    @Override
    public String getInitParameter(String name) {
        return initParameters.getProperty(name);
    }

    /*
     * (non-Javadoc)
     *
     * @see jakarta.servlet.ServletConfig#getInitParameterNames()
     */
    @Override
    public Enumeration getInitParameterNames() {
        return initParameters.propertyNames();
    }

}
