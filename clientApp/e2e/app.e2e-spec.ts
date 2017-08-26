import { CheckpostPage } from './app.po';

describe('checkpost App', () => {
  let page: CheckpostPage;

  beforeEach(() => {
    page = new CheckpostPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
