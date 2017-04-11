<%-- 
    Document   : registerationForm
    Created on : Apr 6, 2017, 10:29:48 AM
    Author     : ahussein
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
        <title>Registration Page</title>
    </head>
    <body>
        <h2>Employee Registration</h2>
        <sf:form method="POST" commandName="employee">

<table align="center" cellpadding = "10">

<!----- First Name ---------------------------------------------------------->
<tr>
<td>Name</td>
<td>
<sf:input path="name"/>
<sf:errors path="name" cssClass="error" />
</td>
</tr>

<!----- Date Of Birth -------------------------------------------------------->
<tr>
<td>Date Of Birth</td>

<td>
<sf:select path="day">
<sf:option value="">Day:</sf:option>
<sf:option value="1">1</sf:option>
<sf:option value="2">2</sf:option>
<sf:option value="3">3</sf:option>

<sf:option value="4">4</sf:option>
<sf:option value="5">5</sf:option>
<sf:option value="6">6</sf:option>
<sf:option value="7">7</sf:option>
<sf:option value="8">8</sf:option>
<sf:option value="9">9</sf:option>
<sf:option value="10">10</sf:option>
<sf:option value="11">11</sf:option>
<sf:option value="12">12</sf:option>

<sf:option value="13">13</sf:option>
<sf:option value="14">14</sf:option>
<sf:option value="15">15</sf:option>
<sf:option value="16">16</sf:option>
<sf:option value="17">17</sf:option>
<sf:option value="18">18</sf:option>
<sf:option value="19">19</sf:option>
<sf:option value="20">20</sf:option>
<sf:option value="21">21</sf:option>

<sf:option value="22">22</sf:option>
<sf:option value="23">23</sf:option>
<sf:option value="24">24</sf:option>
<sf:option value="25">25</sf:option>
<sf:option value="26">26</sf:option>
<sf:option value="27">27</sf:option>
<sf:option value="28">28</sf:option>
<sf:option value="29">29</sf:option>
<sf:option value="30">30</sf:option>

<sf:option value="31">31</sf:option>
</sf:select>

    <sf:select  path="month" required>
<sf:option value="">Month:</sf:option>
<sf:option value="01">Jan</sf:option>
<sf:option value="02">Feb</sf:option>
<sf:option value="03">Mar</sf:option>
<sf:option value="04">Apr</sf:option>
<sf:option value="05">May</sf:option>
<sf:option value="06">Jun</sf:option>
<sf:option value="07">Jul</sf:option>
<sf:option value="08">Aug</sf:option>
<sf:option value="09">Sep</sf:option>
<sf:option value="10">Oct</sf:option>
<sf:option value="11">Nov</sf:option>
<sf:option value="12">Dec</sf:option>
</sf:select>

<sf:select path="year" required>

<sf:option value="">Year:</sf:option>
<sf:option value="2012">2012</sf:option>
<sf:option value="2011">2011</sf:option>
<sf:option value="2010">2010</sf:option>
<sf:option value="2009">2009</sf:option>
<sf:option value="2008">2008</sf:option>
<sf:option value="2007">2007</sf:option>
<sf:option value="2006">2006</sf:option>
<sf:option value="2005">2005</sf:option>
<sf:option value="2004">2004</sf:option>
<sf:option value="2003">2003</sf:option>
<sf:option value="2002">2002</sf:option>
<sf:option value="2001">2001</sf:option>
<sf:option value="2000">2000</sf:option>

<sf:option value="1999">1999</sf:option>
<sf:option value="1998">1998</sf:option>
<sf:option value="1997">1997</sf:option>
<sf:option value="1996">1996</sf:option>
<sf:option value="1995">1995</sf:option>
<sf:option value="1994">1994</sf:option>
<sf:option value="1993">1993</sf:option>
<sf:option value="1992">1992</sf:option>
<sf:option value="1991">1991</sf:option>
<sf:option value="1990">1990</sf:option>

<sf:option value="1989">1989</sf:option>
<sf:option value="1988">1988</sf:option>
<sf:option value="1987">1987</sf:option>
<sf:option value="1986">1986</sf:option>
<sf:option value="1985">1985</sf:option>
<sf:option value="1984">1984</sf:option>
<sf:option value="1983">1983</sf:option>
<sf:option value="1982">1982</sf:option>
<sf:option value="1981">1981</sf:option>
<sf:option value="1980">1980</sf:option>
</sf:select>
<sf:errors path="day" cssClass="error" />
<sf:errors path="month" cssClass="error" />
<sf:errors path="year" cssClass="error" />
</td>
</tr>

<!----- Salary ---------------------------------------------------------->
<tr>
<td>Salary</td>
<td>
    <sf:input type="number" path="salary"/>
    <sf:errors path="salary" cssClass="error" />
</td>
</tr>

<!----- Job title ---------------------------------------------------------->
<tr>
<td>Job title</td>
<td>
<sf:input path="jobTitle"/>
<sf:errors path="jobTitle" cssClass="error" />
</td>
</tr>

<!----- Department ---------------------------------------------------------->
<tr>
<td>Department</td>
<td>
<sf:select path="department" required >

<sf:option value=""></sf:option>
<sf:option value="Production">Production</sf:option>
<sf:option value="Research and Development">Research and Development</sf:option>
<sf:option value="Marketing">Marketing</sf:option>
<sf:option value="Human Resource Management">Human Resource Management</sf:option>
<sf:option value="Accounting and Finance">Accounting and Finance</sf:option>
</sf:select>
<sf:errors path="department" cssClass="error" />
</td>
</tr>


<!----- Email ---------------------------------------------------------->
<tr>
<td>Email</td>
<td>
<sf:input path="email"/>
<sf:errors path="email" cssClass="error" />
</td>
</tr>



<!----- Submit and Reset ------------------------------------------------->
<tr>
<td colspan="2" align="center">
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</td>
</tr>
</table>
</sf:form>
         <a href="empservlet?action=list">View all employees</a><br /><br />
    </body>
</html>
