import React from 'react';

import { translate } from './i18n-util';
import { i18nContext } from './i18n-provider';

/**
 * I18n high order component.
 *
 * It is recommended to be used as a decorator @withI18n.
 *
 * It injects i18n prop that contains {language, messages, languages} and an
 * internationalization function t(code, params).
 *
 * ```js
 * @withI18n
 * class Test extends Component {
 * ...
 * ```
 */
const withI18n =
  BaseComponent =>
    props =>
      <i18nContext.Consumer>
        {
          i18n =>
            <BaseComponent
              {...props}
              i18n={i18n}
              t={(code, params) =>
                translate(i18n.messages, code, params)}
            />
        }
      </i18nContext.Consumer>;

export default withI18n;
