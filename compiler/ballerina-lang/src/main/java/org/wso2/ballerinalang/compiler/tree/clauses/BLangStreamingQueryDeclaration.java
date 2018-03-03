/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.ballerinalang.compiler.tree.clauses;

import org.ballerinalang.model.tree.NodeKind;
import org.ballerinalang.model.tree.clauses.StreamingQueryDeclarationNode;
import org.ballerinalang.model.tree.statements.QueryStatementNode;
import org.ballerinalang.model.tree.statements.StreamingQueryStatementNode;
import org.ballerinalang.model.tree.statements.VariableDefinitionNode;
import org.wso2.ballerinalang.compiler.tree.BLangNode;
import org.wso2.ballerinalang.compiler.tree.BLangNodeVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link StreamingQueryDeclarationNode}.
 */
public class BLangStreamingQueryDeclaration extends BLangNode implements StreamingQueryDeclarationNode {

    private StreamingQueryStatementNode streamingQueryStatement;
    private List<QueryStatementNode> queryStatements = new ArrayList<>();
    private List<VariableDefinitionNode> variableDefinitionList = new ArrayList<>();


    @Override
    public void addVariableDefinition(VariableDefinitionNode variableDefinitionNode) {
        variableDefinitionList.add(variableDefinitionNode);
    }

    @Override
    public List<VariableDefinitionNode> getVariableDefinitions() {
        return variableDefinitionList;
    }

    @Override
    public void setStreamingQuery(StreamingQueryStatementNode streamingQuery) {
        this.streamingQueryStatement = streamingQuery;
    }

    @Override
    public void addQueryStatement(QueryStatementNode queryStatement) {
        queryStatements.add(queryStatement);
    }

    @Override
    public List<QueryStatementNode> getQueryStatements() {
        return this.queryStatements;
    }

    @Override
    public StreamingQueryStatementNode getStreamingQueryStatement() {
        return this.streamingQueryStatement;
    }

    @Override
    public void accept(BLangNodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public NodeKind getKind() {
        return NodeKind.STREAMING_QUERY_DECLARATION;
    }

}
