import { translate } from '../i18n-util';

describe('i18n-util-test', () => {
  describe('translate test', () => {
    const messages = {
      'lang.key1': 'the brown fox jumped over the lazy dog',
      'lang.key2': 'the brown fox {0} jumped over the lazy dog',
      'lang.key3': '{0} the brown fox jumped over the lazy dog {1}',
      'lang.key4': 'the brown fox {1} jumped over the lazy dog {0}',
      'lang.key5': '{0} {1} {2} {3} {4}',
    };

    it('should handle empty values', () => {
      const t1 = translate(messages);
      const t2 = translate(messages, null);
      const t3 = translate(messages, undefined, null);
      const t4 = translate(messages, null, null);

      expect(t1).toBe(undefined);
      expect(t2).toBe(null);
      expect(t3).toBe(undefined);
      expect(t4).toBe(null);
    });

    it('should handle code', () => {
      const t1 = translate(messages, 'lang.key1');
      const t2 = translate(messages, 'lang.key10');
      const t3 = translate(messages, 'lang.key2');

      expect(t1).toBe(messages['lang.key1']);
      expect(t2).toBe('lang.key10');
      expect(t3).toBe(messages['lang.key2']);
    });

    it('should handle params', () => {
      const pets = ['Foxy', 'Doggy'];
      const numbers = ['one', 'two', 'three', 'four', 'five'];

      const t1 = translate(messages, 'lang.key1', pets);
      const t2 = translate(messages, 'lang.key2', pets);
      const t3 = translate(messages, 'lang.key3', pets);
      const t4 = translate(messages, 'lang.key4', pets);
      const t5 = translate(messages, 'lang.key5', numbers);

      expect(t1).toBe(messages['lang.key1']);
      expect(t2).toBe(`the brown fox ${pets[0]} jumped over the lazy dog`);
      expect(t3).toBe(`${pets[0]} the brown fox jumped over the lazy dog ${pets[1]}`);
      expect(t4).toBe(`the brown fox ${pets[1]} jumped over the lazy dog ${pets[0]}`);
      expect(t5).toBe(numbers.join(' '));
    });
  });
});
