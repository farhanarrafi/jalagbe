<%--
  Created by IntelliJ IDEA.
  User: tareq rahman
  Date: 9/10/2017
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<Script>


</Script>

<div class="table-content" id="cetagorie-data">
    <table class="table table-inverse">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Parent Category</th>
            <th>Image</th>
            <th>Created On</th>
            <th>Updated On</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <c:set var="categoryList" value="${categoryResult.categoryList}"/>
        <c:set var="imageFolder" value="${categoryResult.imageFolder}"/>
        <c:forEach var="categoryModel" items="${categoryList}">
            <tr>
                <th scope="row">${categoryModel.id}</th>
                <td>${categoryModel.categoryName}</td>
                <td>${categoryModel.parentCategoryName}</td>
                <td><img src="data:image/jpeg;base64,${categoryModel.image}" height="50" width="50" alt=""></td>
                <td>${categoryModel.createdOn}</td>
                <td>${categoryModel.updatedOn}</td>
                <td>
                    <div class="admin-action">
                        <div class="cetagorie-edit">
                            <a href="#main-body-admin" id="editCetagorie" value="" >EDIT</a>
                        </div>
                        <div class="cetagorie-delete">
                            <a href="#" id="deleteCetagorie" value="" >DELETE</a>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>