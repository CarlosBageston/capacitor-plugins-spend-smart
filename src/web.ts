import { WebPlugin } from '@capacitor/core';

import type { NavigationBarPlugin } from './definitions';

export class NavigationBarWeb extends WebPlugin implements NavigationBarPlugin {
  async setColor(options: { color: string; lightButtons?: boolean }): Promise<void> {
    console.log('Color', options);
    return;
  }
}
