import React from 'react';
import { storiesOf } from '@storybook/react';
import { withKnobs, text, number, boolean } from '@storybook/addon-knobs';

import Spinner from '../spinner';

const stories = storiesOf('Spinner', module);
stories.addDecorator(withKnobs);

stories.add('default', () => (
  <div style={{ width: '100px', height: '100px' }}>
    <Spinner />
  </div>
));

stories.add('with text children', () => (
  <div style={{ width: '100%', height: '100%' }}>
    <Spinner
      loading={boolean('Loading', true)}
      color={text('Color', '#3399ff')}
      size={number('Size', 80)}
    >
      Lorem ipsum dolor sit amet, vix ad omnis dicunt nonumes. Cu recusabo euripidis duo,
      vim tale tempor reprehendunt id. Tamquam tincidunt no cum, mandamus erroribus no eam,
      eu mea novum noster feugait. Id stet detraxit adipisci vim. An duo dictas doctus.
      Sed ad lorem necessitatibus. At mei evertitur inciderint, et quo odio feugait. Amet
      duis adolescens ad usu, dictas menandri recusabo pri id, fugit paulo no eum. Ei sea
      decore efficiendi intellegebat, in prima sententiae pri. In duo etiam dicunt postulant.
      Duo aperiri denique tacimates ei, ad reque commodo luptatum vim. Et per graeco suavitate,
      enim virtute eruditi has ad. Eum no audire forensibus scripserit. Mucius nostrum honestatis
      cum no, vim ad maiorum invenire perpetua. Eu hinc virtute voluptatibus vix, has et volutpat
      iudicabit sadipscing.
      Error ornatus maiestatis ius ad. Et qui utamur perfecto dissentias, an per volutpat repudiare,
      vim an habemus dissentias. Ut alii porro sonet nec, mentitum accommodare cum ea, id diam
      option legimus duo. Eos praesent democritum theophrastus no, elit elaboraret at cum. Et
      cibo iriure veritus pro, cu iisque menandri quo. Appetere antiopam intellegam vel ex.
      Te dicant legere quo. In delenit honestatis vim, quo at ipsum aliquam. Mel ne magna posse
      rationibus, epicuri accumsan postulant ne nec. Putent animal et mel, ut nec possim evertitur,
        natum iriure laboramus id vel. Mei dico volumus id.
      Eros eruditi eligendi eos ea. Alii persius qualisque eos id, magna legimus id sea, suscipit
      placerat est cu. Cum hendrerit definitionem te, duo quis petentium no. Utamur reprehendunt
      et duo, id delenit pertinacia pri, modo verear ad sea. Decore convenire reprehendunt nec ex,
      ad porro timeam nam.
    </Spinner>
  </div>
));

stories.add('with div child', () => (
  <Spinner
    fillContainer={false}
    loading={boolean('Loading', true)}
    color={text('Color', '#3399ff')}
    size={number('Size', 80)}
  >
    <div style={{ width: 600, height: 600, border: '1px dotted black' }}>
      Lorem ipsum dolor sit amet, vix ad omnis dicunt nonumes. Cu recusabo euripidis duo,
      vim tale tempor reprehendunt id. Tamquam tincidunt no cum, mandamus erroribus no eam,
      eu mea novum noster feugait. Id stet detraxit adipisci vim. An duo dictas doctus.
      Sed ad lorem necessitatibus. At mei evertitur inciderint, et quo odio feugait. Amet
      duis adolescens ad usu, dictas menandri recusabo pri id, fugit paulo no eum. Ei sea
      decore efficiendi intellegebat, in prima sententiae pri. In duo etiam dicunt postulant.
      Duo aperiri denique tacimates ei, ad reque commodo luptatum vim. Et per graeco suavitate,
      enim virtute eruditi has ad. Eum no audire forensibus scripserit. Mucius nostrum honestatis
      cum no, vim ad maiorum invenire perpetua. Eu hinc virtute voluptatibus vix, has et volutpat
      iudicabit sadipscing.
      Error ornatus maiestatis ius ad. Et qui utamur perfecto dissentias, an per volutpat repudiare,
      vim an habemus dissentias. Ut alii porro sonet nec, mentitum accommodare cum ea, id diam
      option legimus duo. Eos praesent democritum theophrastus no, elit elaboraret at cum. Et
      cibo iriure veritus pro, cu iisque menandri quo. Appetere antiopam intellegam vel ex.
      Te dicant legere quo. In delenit honestatis vim, quo at ipsum aliquam. Mel ne magna posse
      rationibus, epicuri accumsan postulant ne nec. Putent animal et mel, ut nec possim evertitur,
        natum iriure laboramus id vel. Mei dico volumus id.
      Eros eruditi eligendi eos ea. Alii persius qualisque eos id, magna legimus id sea, suscipit
      placerat est cu. Cum hendrerit definitionem te, duo quis petentium no. Utamur reprehendunt
      et duo, id delenit pertinacia pri, modo verear ad sea. Decore convenire reprehendunt nec ex,
      ad porro timeam nam.
    </div>
  </Spinner>
));
