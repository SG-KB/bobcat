/*
 * Copyright 2016 Cognifide Ltd..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cognifide.qa.bb.aem.touch.siteadmin.aem61;

import java.util.Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cognifide.qa.bb.aem.touch.siteadmin.aem61.conditions.NotDisabledCondition;
import com.cognifide.qa.bb.constants.Timeouts;
import com.cognifide.qa.bb.loadable.annotation.LoadableComponent;
import com.cognifide.qa.bb.provider.selenium.BobcatWait;
import com.cognifide.qa.bb.qualifier.FindPageObject;
import com.cognifide.qa.bb.qualifier.Global;
import com.cognifide.qa.bb.qualifier.PageObject;
import com.google.inject.Inject;

@PageObject
public class CreatePageWizard {

  @Inject
  private BobcatWait bobcatWait;

  @FindPageObject
  private TemplateList templateList;

  @Global
  @FindBy(css = "div.cq-siteadmin-admin-properties-tabs > div.coral-TabPanel-content")
  private CreatePageProperties createPageProperties;

  @Global
  @FindBy(css = "button.coral-Wizard-nextButton[data-foundation-wizard-control-action='next']")
  private WebElement nextButton;

  @Global
  @FindBy(css = "button.coral-Wizard-nextButton[type='submit']")
  private WebElement createButton;

  @Global
  @FindBy(xpath = "//button[contains(text(), 'Done')]")
  private WebElement doneButtonOnModal;

  public CreatePageWizard selectTemplate(String templateName) {
    templateList.selectTemplate(templateName);
    nextButton.click();
    return this;
  }

  public CreatePageWizard provideName(String name) {
    createPageProperties.getNameTextField().sendKeys(name);
    return this;
  }

  public CreatePageWizard provideTitle(String title) {
    createPageProperties.getTitleTextField().sendKeys(title);
    return this;
  }

  public void submit() {
    getCreateButton().click();
    getDoneButtonOnModal().click();
  }

  public WebElement getCreateButton() {
    bobcatWait.withTimeout(Timeouts.SMALL).until(input -> Objects.isNull(createButton.getAttribute("disabled")));
    return createButton;
  }

  public WebElement getDoneButtonOnModal() {
    return bobcatWait.withTimeout(Timeouts.SMALL).until(ExpectedConditions.visibilityOf(doneButtonOnModal));
  }
}
