/**
 * Copyright (c) 2006-2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 */
package at.jku.se.eclipse.emf.ecore.change;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.jku.se.eclipse.emf.ecore.change.ResourceChange#getResourceURI <em>Resource URI</em>}</li>
 *   <li>{@link at.jku.se.eclipse.emf.ecore.change.ResourceChange#getResource <em>Resource</em>}</li>
 *   <li>{@link at.jku.se.eclipse.emf.ecore.change.ResourceChange#getValue <em>Value</em>}</li>
 *   <li>{@link at.jku.se.eclipse.emf.ecore.change.ResourceChange#getListChanges <em>List Changes</em>}</li>
 * </ul>
 *
 * @see at.jku.se.eclipse.emf.ecore.change.ChangePackage#getResourceChange()
 * @model
 * @generated
 */
public interface ResourceChange extends Change
{
  /**
	 * Returns the value of the '<em><b>Resource URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource URI</em>' attribute.
	 * @see #setResourceURI(String)
	 * @see at.jku.se.eclipse.emf.ecore.change.ChangePackage#getResourceChange_ResourceURI()
	 * @model
	 * @generated
	 */
  String getResourceURI();

  /**
	 * Sets the value of the '{@link at.jku.se.eclipse.emf.ecore.change.ResourceChange#getResourceURI <em>Resource URI</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource URI</em>' attribute.
	 * @see #getResourceURI()
	 * @generated
	 */
  void setResourceURI(String value);

  /**
	 * Returns the value of the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' attribute.
	 * @see #setResource(Resource)
	 * @see at.jku.se.eclipse.emf.ecore.change.ChangePackage#getResourceChange_Resource()
	 * @model transient="true" derived="true"
	 * @generated
	 */
  Resource getResource();

  /**
	 * Sets the value of the '{@link at.jku.se.eclipse.emf.ecore.change.ResourceChange#getResource <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' attribute.
	 * @see #getResource()
	 * @generated
	 */
  void setResource(Resource value);

  /**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see at.jku.se.eclipse.emf.ecore.change.ChangePackage#getResourceChange_Value()
	 * @model many="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
  EList<?> getValue();

  /**
	 * Returns the value of the '<em><b>List Changes</b></em>' containment reference list.
	 * The list contents are of type {@link at.jku.se.eclipse.emf.ecore.change.ListChange}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>List Changes</em>' containment reference list.
	 * @see at.jku.se.eclipse.emf.ecore.change.ChangePackage#getResourceChange_ListChanges()
	 * @model containment="true"
	 * @generated
	 */
  EList<ListChange> getListChanges();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void apply();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void applyAndReverse();

  /**
	 * <!-- begin-user-doc -->
   * @since 2.7
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void reverse();

} // ResourceChange
