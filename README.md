# capacitor-plugins-spend-smart

A Capacitor v7 plugin that allows changing the navigation bar color on Android, including the button colors. Ideal for any app that needs visual customization of the navigation bar.

## Install

Since this plugin is hosted on **GitHub Packages**, you need a **personal access token** to install it. Follow these steps:

1. Create a personal access token on GitHub with the following permissions:
   - `read:packages` (required)
   - Optionally, include `repo` permissions if needed

2. Add the token to your project. Create or edit a file named `.npmrc` in the root of your project with:

```ini
@carlosbageston:registry=https://npm.pkg.github.com/
//npm.pkg.github.com/:_authToken=YOUR_PERSONAL_ACCESS_TOKEN


npm install @carlosbageston/capacitor-plugins-spend-smart@1.0.0
npx cap sync

```
## API

<docgen-index>

* [`setColor(...)`](#setcolor)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### setColor(...)

```typescript
setColor(options: { color: string; lightButtons?: boolean; }) => Promise<void>
```

Changes the navigation bar color and the button colors

| Param         | Type                                                    |
| ------------- | ------------------------------------------------------- |
| **`options`** | <code>{ color: string; lightButtons?: boolean; }</code> |

--------------------

## Uso

Import the plugin and call the setColor function:

```typescript
import { NavigationBar } from '@carlosbageston/capacitor-plugins-spend-smart';


await NavigationBar.setColor({ color: '#000000', lightButtons: true });

await NavigationBar.setColor({ color: '#FFFFFF', lightButtons: false });

await NavigationBar.setColor({ color: '#FF0000', lightButtons: true });
```
</docgen-api>
