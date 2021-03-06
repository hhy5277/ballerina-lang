/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.ballerinalang.langserver.compiler.workspace.repository;

import org.ballerinalang.langserver.compiler.workspace.WorkspaceDocumentException;
import org.ballerinalang.langserver.compiler.workspace.WorkspaceDocumentManager;
import org.ballerinalang.model.elements.PackageID;
import org.wso2.ballerinalang.compiler.packaging.converters.FileSystemSourceInput;

import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * LSInMemorySourceEntry.
 */
class LSInMemorySourceEntry extends FileSystemSourceInput {

    private WorkspaceDocumentManager documentManager;
    LSInMemorySourceEntry(Path path, Path root, PackageID pkgId, WorkspaceDocumentManager documentManager) {
        super(path, root.resolve(Paths.get(pkgId.name.value)));
        this.documentManager = documentManager;
    }

    @Override
    public byte[] getCode() {
        try {
            return documentManager.getFileContent(this.getPath()).getBytes("UTF-8");
        } catch (UnsupportedEncodingException | WorkspaceDocumentException e) {
            throw new RuntimeException("Error in loading package source entry '" + getPath() +
                                               "': " + e.getMessage(), e);
        }
    }
}
