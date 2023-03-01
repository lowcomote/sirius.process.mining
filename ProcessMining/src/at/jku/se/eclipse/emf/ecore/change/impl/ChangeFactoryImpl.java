/**
 * Copyright (c) 2003-2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 */
package at.jku.se.eclipse.emf.ecore.change.impl;


import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.resource.Resource;

import at.jku.se.eclipse.emf.ecore.change.*;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChangeFactoryImpl extends EFactoryImpl implements ChangeFactory
{
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ChangeFactory init()
  {
		try {
			ChangeFactory theChangeFactory = (ChangeFactory)EPackage.Registry.INSTANCE.getEFactory(ChangePackage.eNS_URI);
			if (theChangeFactory != null) {
				return theChangeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ChangeFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ChangeFactoryImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass)
  {
		switch (eClass.getClassifierID()) {
			case ChangePackage.CHANGE_DESCRIPTION: return createChangeDescription();
			case ChangePackage.EOBJECT_TO_CHANGES_MAP_ENTRY: return (EObject)createEObjectToChangesMapEntry();
			case ChangePackage.FEATURE_CHANGE: return createFeatureChange();
			case ChangePackage.LIST_CHANGE: return createListChange();
			case ChangePackage.RESOURCE_CHANGE: return createResourceChange();
			case ChangePackage.FEATURE_MAP_ENTRY: return createFeatureMapEntry();
			case ChangePackage.CHANGE: return createChange();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
		switch (eDataType.getClassifierID()) {
			case ChangePackage.CHANGE_KIND:
				return createChangeKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
		switch (eDataType.getClassifierID()) {
			case ChangePackage.CHANGE_KIND:
				return convertChangeKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ChangeDescription createChangeDescription()
  {
		ChangeDescriptionImpl changeDescription = new ChangeDescriptionImpl();
		return changeDescription;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Map.Entry<EObject, EList<FeatureChange>> createEObjectToChangesMapEntry()
  {
		EObjectToChangesMapEntryImpl eObjectToChangesMapEntry = new EObjectToChangesMapEntryImpl();
		return eObjectToChangesMapEntry;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public FeatureChange createFeatureChange()
  {
		FeatureChangeImpl featureChange = new FeatureChangeImpl();
		return featureChange;
	}

  public FeatureChange createFeatureChange(EStructuralFeature feature, Object oldValue, Notification notification, long timeStamp)
  {
    FeatureChangeImpl featureChange = new FeatureChangeImpl(feature, oldValue, notification, timeStamp);
    return featureChange;
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ListChange createListChange()
  {
		ListChangeImpl listChange = new ListChangeImpl();
		return listChange;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ResourceChange createResourceChange()
  {
		ResourceChangeImpl resourceChange = new ResourceChangeImpl();
		return resourceChange;
	}

  public ResourceChange createResourceChange(Resource resource, EList<Object> oldValue, long timeStamp)
  {
    ResourceChangeImpl resourceChange = new ResourceChangeImpl(resource, oldValue, timeStamp);
    return resourceChange;
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public FeatureMapEntry createFeatureMapEntry()
  {
		FeatureMapEntryImpl featureMapEntry = new FeatureMapEntryImpl();
		return featureMapEntry;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Change createChange() {
		ChangeImpl change = new ChangeImpl();
		return change;
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ChangeKind createChangeKindFromString(EDataType eDataType, String initialValue)
  {
		ChangeKind result = ChangeKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertChangeKindToString(EDataType eDataType, Object instanceValue)
  {
		return instanceValue == null ? null : instanceValue.toString();
	}

  public FeatureMapEntry createFeatureMapEntry(EStructuralFeature feature, Object value)
  {
    FeatureMapEntryImpl featureMapEntry = new FeatureMapEntryImpl(feature, value);
    return featureMapEntry;
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ChangePackage getChangePackage()
  {
		return (ChangePackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static ChangePackage getPackage()
  {
		return ChangePackage.eINSTANCE;
	}

  public Map.Entry<EObject, EList<FeatureChange>> createEObjectToChangesMapEntry(EObject eObject)
  {
    EObjectToChangesMapEntryImpl eObjectToChangesMapEntry = new EObjectToChangesMapEntryImpl();
    eObjectToChangesMapEntry.setKey(eObject);
    return eObjectToChangesMapEntry;
  }

} //ChangeFactoryImpl
