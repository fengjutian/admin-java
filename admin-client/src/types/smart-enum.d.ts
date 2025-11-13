
export interface SmartEnumWrapper<T> {
  [key: string]: SmartEnum<T>;
}

export interface SmartEnum<T> {
  [key: string]: SmartEnumItem<T>;
}

interface SmartEnumItem<T> {
  value: T;
  desc: string;
}

interface SmartEnumPlugin {
  getDescByValue(constantName: string, value: string | number | undefined): string;

  getValueDescList(constantName: string): SmartEnumItem[];

  getValueDesc(constantName: string): { [key: string]: string };
}
